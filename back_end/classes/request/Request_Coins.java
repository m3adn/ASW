/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back_end.classes.request;

/**
 *
 * @author epilif3sotnas
 */
public class Request_Coins {
    private String coin;    // coin is a cryptocurrency
    private float units;

    public Request_Coins(String _coin, float _units) {
        // verify data
        this.coin = _coin;
        this.units = _units;
    }

    public String getCoin() {
        return coin;
    }

    public float getUnits() {
        return units;
    }
}
