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

		onLanguageChange: function(oEvent) {
			sap.ui.getCore().getConfiguration().setLanguage(oEvent.getSource().getSelectedKey());
		},
		
		geti18nText: function(othis, key){
			return othis.getView().getModel("i18n").getResourceBundle().getText(key);
		}

	});
});