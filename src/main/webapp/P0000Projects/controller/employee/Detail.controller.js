sap.ui.define([
    "sap/ui/core/mvc/Controller",
    "sap/ui/core/routing/History",
    "sap/m/MessageToast",
    "sap/ui/model/json/JSONModel",
    "sap/ui/core/UIComponent"
], function (Controller, History, MessageToast, JSONModel, UIComponent) {
    "use strict";

    return Controller.extend("sap.ui.demo.basicTemplate.controller.employee.Detail", {

        onInit: function () {
            //const oViewModel = new JSONModel({ currency: "EUR" });
            //this.getView().setModel(oViewModel, "view");

            const oRouter = UIComponent.getRouterFor(this);
            oRouter.getRoute("Detail2").attachPatternMatched(this._onObjectMatched, this);
        },

        _onObjectMatched: function (oEvent) {
            //this.byId("rating").reset();
            console.log("/" + window.decodeURIComponent(oEvent.getParameter("arguments").invoicePath));

            this.getView().bindElement({
                path: "/" + window.decodeURIComponent(oEvent.getParameter("arguments").invoicePath),
                model: "remoteOData"
            });
        },

        onNavBack: function () {
            const oHistory = History.getInstance();
            const sPreviousHash = oHistory.getPreviousHash();

            if (sPreviousHash !== undefined) {
                window.history.go(-1);
            } else {
                const oRouter = UIComponent.getRouterFor(this);
                oRouter.navTo("appHome", {}, true);
            }
        }/*,

        onRatingChange: function (oEvent) {
            const fValue = oEvent.getParameter("value");
            const oResourceBundle = this.getView().getModel("i18n").getResourceBundle();

            MessageToast.show(oResourceBundle.getText("ratingConfirmation", [fValue]));
        }*/
    });
});