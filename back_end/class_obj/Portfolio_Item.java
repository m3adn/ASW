/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back_end.class_obj;

/**
 *
 * @author epilif3sotnas
 */
public class Portfolio_Item {
    private String coin;
    private float units;
    private String purchaseDate;
    private float purchaseValue;
    private float currentPrice;
    private float percentageChange;
    private float currentAssetValue;
    
    public Portfolio_Item (String _coin, float _units, String _purchaseDate, float _purchaseValue) {
        // verify data
        this.coin = _coin;
        this.units = _units;
        this.purchaseDate = _purchaseDate;
        this.purchaseValue = _purchaseValue;
    }

    public Portfolio_Item (float _currentPrice, float _percentageChange, float _currentAssetValue) {
        // verify data
        this.currentPrice = _currentPrice;
        this.percentageChange = _percentageChange;
        this.currentAssetValue = _currentAssetValue;
    }

    public String getCoin() {
        return coin;
    }

    public float getUnits() {
        return units;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public float getPurchaseValue() {
        return purchaseValue;
    }

    public float getCurrentPrice() {
        return currentPrice;
    }

    public float getPercentageChange() {
        return percentageChange;
    }

    public float getCurrentAssetValue() {
        return currentAssetValue;
    }
    
    
}
