sap.ui.define([
	"ditum/ui/kioskKioskApp/controller/BaseController",
	"sap/ui/core/UIComponent",
	"sap/ui/model/json/JSONModel"
], function(BaseController, UIComponent, JSONModel) {
	"use strict";

	return BaseController.extend("ditum.ui.kioskKioskApp.controller.ReadNFC", {

		onInit: function() {
			document.addEventListener('deviceready', this.onDeviceReady.bind(this), false);
			this._oRouter = UIComponent.getRouterFor(this);
			this._oRouter.getRoute("ReadNFC").attachPatternMatched(this._onObjectMatched, this);
			this.initializeAppLanguages();
		},

		onDeviceReady: function() {
			this._scanNFC();
		},

		onChangePIN: function(oEvent) {
			var that = this;
			var userEnteredPIN = oEvent.getSource().getValue();
			if (userEnteredPIN.length === 4) {
				this.pinReminderTrigger.removeListener(that.remindUserforPIN, that);
				this._oRouter.navTo("ResultNFC");
			}
		},

		setPasscodeCircle: function(circleCount) {
			var circleEleArr = $(".passcodeCircles .circle");
			for (var i = 0; i < circleEleArr.length; i++) {
				$(circleEleArr[i]).removeClass("circle-filled");
				if (!$(circleEleArr[i]).hasClass("circle-default"))
					$(circleEleArr[i]).addClass("circle-default");
			}
			for (var j = 0; j < circleCount; j++) {
				$(circleEleArr[j]).removeClass("circle-default");
				$(circleEleArr[j]).addClass("circle-filled");
			}
		},

		onPasscodeKeyPress: function(event) {
			var that = this;
			var keyPressed = parseInt(event.getSource().data("keyPressed"));
			if (keyPressed === -1) {
				// delete button is pressed
				if (this.passcodeArr.length >= 1) {
					this.passcodeArr.pop();
					this.setPasscodeCircle(this.passcodeArr.length);
				}
			} else if (keyPressed === -2) {
				// kiosk mode button
				this.pinReminderTrigger.removeListener(that.remindUserforPIN, that);
				this._applyWaitNFCMode();
			} else if (keyPressed >= 0 && keyPressed <= 9) {
				// digit key button is pressed
				if (this.passcodeArr.length <= 3) {
					this.passcodeArr.push(keyPressed);
					this.setPasscodeCircle(this.passcodeArr.length);
					if (this.passcodeArr.length === 4) {
						this.pinReminderTrigger.removeListener(that.remindUserforPIN, that);
						this.setUserModel(this.passcodeArr.join(''));
						this._oRouter.navTo("ResultNFC");
					}
				}
			}
		},

		setUserModel: function(pin) {
			var userJSONModel = new JSONModel();
			userJSONModel.setData({
				"uuid": this.uuid,
				"serialNo": this.serial,
				"passNo": this.passNo,
				"pin": pin,
				"languageCode": sap.ui.getCore().getConfiguration().getLanguage()
			});
			this.getOwnerComponent().setModel(userJSONModel, "user");
		},

		setIntervalTrigger: function() {
			var that = this;
			this.pinReminderTrigger = new sap.ui.core.IntervalTrigger(5000);
			this.pinReminderTrigger.addListener(that.remindUserforPIN, that);
		},

		remindUserforPIN: function() {
			var that = this;
			this.reminderCount++;
			if (this.reminderCount <= 4 && this.reminderCount > 1) {
				sap.m.MessageToast.show(this.geti18nText(this, "msgPinIncomplete"));
			} else if (this.reminderCount > 1) {
				sap.m.MessageToast.show(this.geti18nText(this, "msgPinIncompleteReset"));
				this.pinReminderTrigger.removeListener(that.remindUserforPIN, that);
				this._applyWaitNFCMode();
			}
		},

		_onObjectMatched: function() {
			this.byId("idLangSelect").setSelectedKey(sap.ui.getCore().getConfiguration().getLanguage());
			this._applyWaitNFCMode();
			this.reminderCount = 0;
			this.setAnnouncement();
			this.passcodeArr = [];
			this.setPasscodeCircle(this.passcodeArr);
		},

		_scanNFC: function() {
			var that = this;
			nfc.addTagDiscoveredListener(
				function(nfcEvent) {
					var tag = nfcEvent.tag;
					var ndefMessage = tag.ndefMessage;
					//get pass no from NFC Scan
					that.passNo=nfc.bytesToHexString(tag.id);
					//get UUID and serialno of tablet
					that.uuid=device.uuid;
					that.serial=device.serial;
					//show PIN entry mode
					that._applyPINEntryMode();
					//start timer
					that.setIntervalTrigger();
				},
				function() { // success callback
					//sap.m.MessageToast.show("Waiting for NDEF tag");
				},
				function(error) { // error callback
					sap.m.MessageToast.show("Error adding NDEF listener " + JSON.stringify(error));
				}
			);
		},

		_applyPINEntryMode: function() {
			this.reminderCount = 0;
			this.getView().byId("idWaitNFC").setVisible(false);
			this.getView().byId("idWaitNFCText").setVisible(false);
			this.getView().byId("idPIN").setVisible(true);
			this.getView().byId("idTextMsg").setText(this.geti18nText(this, "msgEnterPIN"));
		},

		_applyWaitNFCMode: function() {
			this.getView().byId("idWaitNFC").setVisible(true);
			this.getView().byId("idWaitNFCText").setVisible(true);
			this.getView().byId("idPIN").setVisible(false);
			this.passcodeArr = [];
			this.setPasscodeCircle(this.passcodeArr);
			this.getView().byId("idTextMsg").setText(this.geti18nText(this, "msgReadNFC"));
		}

	});
});