package pl.oskarpolak.jpademo.models.services;


import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import pl.oskarpolak.jpademo.models.BarcodeEntity;

import java.util.ArrayList;
import java.util.List;

@Service
@Scope(scopeName = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class BasketService {
    private List<BarcodeEntity> barcodeEntityList;

    public BasketService(){
        barcodeEntityList = new ArrayList<>();
    }

    public void addProductToList(BarcodeEntity barcodeEntity){
        barcodeEntityList.add(barcodeEntity);
    }

    public void removeProductFromList(int id){
        for (int i = 0; i <barcodeEntityList.size() ; i++) {
            if (barcodeEntityList.get(i).getId() ==id){
                barcodeEntityList.remove(i);
            }

        }
    }

    public int getBasketSize(){
        return barcodeEntityList.size();
    }

    public List<BarcodeEntity> getBasketList() {
        return barcodeEntityList;
    }

    public boolean isIdOnList(int id) {
        return  barcodeEntityList.stream().anyMatch(s -> s.getId() == id);
    }
}
