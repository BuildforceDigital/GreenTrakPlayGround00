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

		_onObjectMatched: function() {
			this.byId("idLangSelect").setSelectedKey(sap.ui.getCore().getConfiguration().getLanguage());
			this._applyWaitNFCMode();
			this.reminderCount = 0;
		},

		_scanNFC: function() {
			var that = this;
			nfc.addTagDiscoveredListener(
				function(nfcEvent) {
					var tag = nfcEvent.tag;
					var ndefMessage = tag.ndefMessage;

					sap.m.MessageToast.show(nfc.bytesToHexString(tag.id));
					that._applyPINEntryMode();
					//set trigger
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
			this.getView().byId("idPIN").setValue("");
			this.getView().byId("idTextMsg").setText(this.geti18nText(this, "msgReadNFC"));
		}

	});
});