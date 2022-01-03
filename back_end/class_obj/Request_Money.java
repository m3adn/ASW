/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back_end.class_obj;

/**
 *
 * @author epilif3sotnas
 */
public class Request_Money {
    private String coin;    // coin is a fiat currency
    private float units;
    private boolean req;    // req = true -> deposit   req = false -> withdraw

    public Request_Money (String _coin, float _units, boolean _req) {
        this.coin = _coin;
        this.units = _units;
        this.req = _req;
    }

    public String getCoin () {
        return coin;
    }

    public float getUnits () {
        return units;
    }

    public boolean isReq () {
        return req;
    }
}
