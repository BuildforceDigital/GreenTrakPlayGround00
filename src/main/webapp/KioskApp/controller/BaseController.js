sap.ui.define([
	"sap/ui/core/mvc/Controller",
	"sap/ui/model/json/JSONModel"
], function(Controller, JSONModel) {
	"use strict";

	return Controller.extend("ditum.ui.kioskKioskApp.controller.BaseController", {

		initializeAppLanguages: function() {
			var languageModel = new JSONModel();
			var languageJSON = {
				languages: [{
					key: "en",
					text: "English"
				}, {
					key: "es",
					text: "Español"
				}, {
					key: "fr",
					text: "Français"
				}, {
					key: "de",
					text: "Deutsche"
				}, {
					key: "pl",
					text: "Polskie"
				}, {
					key: "nl",
					text: "Nederlands"
				}],
				defaultkey: "en"
			};
			languageModel.setData(languageJSON);
			this.getView().setModel(languageModel, "langmodel");
		},

		getBaseURL: function() {
			var baseurl = "http://192.168.1.2:5000/kiosk";
			return baseurl;
		},

		setAnnouncement: function() {
			var that = this;
			//call announcement endpoint
			var successCallback = function(data) {
				var message = "<strong>" + data.message_subject + ": </strong>" + "<em>" + data.message_text + "</em>";
				that.byId("idAnnouncement").setText(message);
			};
			var errorCallback = function(error) {
				sap.m.MessageToast.show(error.status + " " + error.statusText);
			};
			var sURL = this.getBaseURL() + "/announcement/" + sap.ui.getCore().getConfiguration().getLanguage();
			$.ajax({
				type: "GET",
				url: sURL,
				dataType: "json",
				error: errorCallback,
				success: successCallback
			});

		},

		onLanguageChange: function(oEvent) {
			sap.ui.getCore().getConfiguration().setLanguage(oEvent.getSource().getSelectedKey());
			this.setAnnouncement();
		},

		geti18nText: function(othis, key) {
			return othis.getView().getModel("i18n").getResourceBundle().getText(key);
		}

	});
});