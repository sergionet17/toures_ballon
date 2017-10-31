/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netgloo.models;

public class ValueExampleObject {

    private String name;
    private String developer;

    public ValueExampleObject(String name, String developer) {
        this.name = name;
        this.developer = developer;
    }

    public String getName() {
        return name;
    }

    public String getDeveloper() {
        return developer;
    }

}
