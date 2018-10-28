package pl.oskarpolak.jpademo.models;

import org.hibernate.validator.constraints.br.CPF;
import pl.oskarpolak.jpademo.models.forms.BarcodeForm;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "barcode")
public class BarcodeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "product_name")
    private String productName;
    @Column(name =  "company_name")
    private String productCompany;
    private String barcode;
    private int weight;

    public BarcodeEntity() { }

    public BarcodeEntity(BarcodeForm barcodeForm){
        setWeight(barcodeForm.getWeight());
        setBarcode(barcodeForm.getBarcode());
        setProductName(barcodeForm.getProductName());
        setProductCompany(barcodeForm.getCompanyName());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCompany() {
        return productCompany;
    }

    public void setProductCompany(String productCompany) {
        this.productCompany = productCompany;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BarcodeEntity that = (BarcodeEntity) o;
        return id == that.id &&
                weight == that.weight &&
                Objects.equals(productName, that.productName) &&
                Objects.equals(productCompany, that.productCompany) &&
                Objects.equals(barcode, that.barcode);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, productName, productCompany, barcode, weight);
    }

    @Override
    public String toString() {
        return "BarcodeEntity{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productCompany='" + productCompany + '\'' +
                ", barcode='" + barcode + '\'' +
                ", weight=" + weight +
                '}';
    }
}
