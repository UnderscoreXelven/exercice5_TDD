package org.example.model;

public class MarketSystem {
    public static void updateProduit(Produit produit) {
        produit.setSellIn(produit.getSellIn() - 1);


        if(produit.getType().equals("produit laitier")){
            //Si produit laitier
            if(produit.getName().equals("brie vieilli")){
                //Si brie vieilli
                produit.setQuality(produit.getQuality() + 1);
                if(produit.getQuality() > 50) {
                    produit.setQuality(50);
                }
            } else{
                //Autres produits laitiers
                if(produit.getSellIn() < 0) {
                    //Les produits laitiers se dégradent 4x plus vite si sellIn à 0
                    produit.setQuality(produit.getQuality() - 4);
                    if(produit.getQuality() < 0) {
                        produit.setQuality(0);
                    }
                } else{
                    //Les produits laitiers se dégradent 2x plus vite que les autres produits en temps normal
                    produit.setQuality(produit.getQuality() - 2);
                }
            }
        } else{
            //Autres produits
            if(produit.getSellIn() < 0) {
                //Les autres produits se dégradent 2x plus vie si sellIn à 0
                produit.setQuality(produit.getQuality() - 2);
                if(produit.getQuality() < 0) {
                    produit.setQuality(0);
                }
            } else{
                produit.setQuality(produit.getQuality() - 1);
            }
        }
    }
}
