/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back_end.class_obj;

/**
 *
 * @author epilif3sotnas
 */
public class Request_Coins {
    private String coin;    // coin is a cryptocurrency
    private float units;
    private boolean req;    // req = true -> buy   req = false -> sell

    public Request_Coins(String _coin, float _units, boolean _req) {
        // verify data
        this.coin = _coin;
        this.units = _units;
        this.req = _req;
    }

    public String getCoin() {
        return coin;
    }

    public float getUnits() {
        return units;
    }

    public boolean isReq() {
        return req;
    }
    
    
}
