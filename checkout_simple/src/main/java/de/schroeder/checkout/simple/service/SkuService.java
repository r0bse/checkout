package de.schroeder.checkout.simple.service;

import de.schroeder.checkout.simple.domain.SkuEntity;

/**
 * @author schroeder
 * @date 05. Jul 2016
 */
public class SkuService {

    public SkuEntity createProduct(char productName){
        return new SkuEntity( productName );
    }
}
