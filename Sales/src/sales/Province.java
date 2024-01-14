

package sales;

import java.io.Serializable;

/**
 *
 * @author NAKS MTSHATSHENI
 */
public class Province implements Serializable{
    private int id, litres;
    private String provinceName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLitres() {
        return litres;
    }

    public void setLitres(int litres) {
        this.litres = litres;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }
    
    
    
}
