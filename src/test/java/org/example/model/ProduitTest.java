package org.example.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProduitTest {
    private Produit produit;

    @BeforeEach
    public void setUp() {
        produit = new Produit();
        produit.setName("Pomme");
        produit.setSellIn(10);
        produit.setQuality(20);
        produit.setType("fruit");
    }

    @Test
    public void whenSellIn_Zero_thenQualityDecrease_TwoTimesFaster(){
        // Arrange
        produit.setSellIn(0);
        produit.setQuality(10);

        // Act
        MarketSystem.updateProduit(produit);

        // Assert
        Assertions.assertEquals(8, produit.getQuality());
    }

    @Test
    public void quality_ShouldNeverBeNegative(){
        // Arrange
        produit.setSellIn(0);
        produit.setQuality(0);

        // Act
        MarketSystem.updateProduit(produit);

        // Assert
        Assertions.assertEquals(0, produit.getQuality());
    }

    @Test
    public void quality_ShouldNeverBeMoreThan50(){
        // Arrange
        produit.setSellIn(0);
        produit.setQuality(50);
        produit.setName("brie vieilli");
        produit.setType("produit laitier");

        // Act
        MarketSystem.updateProduit(produit);

        // Assert
        Assertions.assertEquals(50, produit.getQuality());
    }

    @Test
    public void whenProductName_brieVieilli_thenQuality_Increase(){
        // Arrange
        produit.setSellIn(10);
        produit.setQuality(20);
        produit.setName("brie vieilli");
        produit.setType("produit laitier");

        // Act
        MarketSystem.updateProduit(produit);

        // Assert
        Assertions.assertEquals(21, produit.getQuality());
    }

    @Test
    public void whenProductType_ProduitLaitier_thenQualityDecrease_TwoTimesFaster(){
        // Arrange
        produit.setSellIn(10);
        produit.setQuality(20);
        produit.setName("brie");
        produit.setType("produit laitier");

        // Act
        MarketSystem.updateProduit(produit);

        // Assert
        Assertions.assertEquals(18, produit.getQuality());
    }
}
