package com.esprit.examen.controllers;

//import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import com.esprit.examen.entities.Produit;
import com.esprit.examen.repositories.ProduitRepository;

import com.esprit.examen.services.ProduitServiceImpl;


import io.swagger.annotations.Api;


@RestController
@CrossOrigin("*")
@Api(tags = "Gestion des produits")
@RequestMapping("/produit")
public class ProduitRestController {

	@Autowired
    private ProduitServiceImpl prodServ;
    @Autowired
    ProduitRepository prodRepo;




    @RestController
    @RequestMapping("/products")
    public class ListProducts {
        @GetMapping
        @ResponseStatus(HttpStatus.OK)
        public ResponseEntity<List<Produit>> listAllUsers_whenGetUsers() {
            return ResponseEntity.ok().body(prodServ.getAll());
        }
    }


//    @GetMapping(value = "/greetings")
//    public String greetings() {
//        return "Greetings from Spring Boot!";
//    }
////:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::://///////////
    //ADD PRODUCT
   
    @PostMapping("/productsADD")
    public ResponseEntity<?> addProduct(@RequestBody Produit p) {
        return new ResponseEntity<>(prodServ.addProduct(p), HttpStatus.OK);
   }

    // GET ALL PRODUCTS
  
    @GetMapping("/products")
    public List<Produit> getAllProductsRecords() {
       return prodRepo.findAll();
  }

    // GET ALL PRODUCTS
   // @ApiOperation(value = "getting product by ID")
   // @GetMapping(value = "{id}")
//    public Product getProductsById(@PathVariable(value = "id") Long id) {
//        return prodRepo.findById(id).get();
//    }
/////:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::://///////////




//////////////////////////////////////////////////////////////////////////////////////
//    @PostMapping("/products")
//    public Product addProductRecord(@RequestBody Product productRecord){
//        return prodRepo.save(productRecord);
//    }

//    @PutMapping
//    public Product updateProductRecord(@RequestBody Product productRecord) throws NotFoundException{
//        Optional<Product> optionalProduct = prodRepo.findById(productRecord.getId());
//        if(!optionalProduct.isPresent()){
//            throw new NotFoundException("Product with Id:" + productRecord.getId() + "does not exist");
//        }
//        Product existingProductRecord = optionalProduct.get();
//        existingProductRecord.setTitle(productRecord.getTitle());
//        existingProductRecord.setDescription(productRecord.getDescription());
//        return prodRepo.save(existingProductRecord);
//    }

//////////////////////////////////////////////////////////////////////////////////
   /* // GET PRODUCT BY ID
    @GetMapping(value = "/products/get/{id}")
    public @ResponseBody ResponseEntity<product> getprodById(@PathVariable("id") long id){
        product prod= prodRepo.findById(id);
        return new ResponseEntity<product>(prod,HttpStatus.OK);
    }*/
////:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::://///////////
    //DELETE ALL
//    @ApiOperation(value = "Removing all products on stock")
//    @DeleteMapping(value = "/products")
//    @ResponseBody
//    public String DeleteAll() {
//        prodServ.deleteAll();
//        return "List of products has been deleted successfully";
//    }

    //DELETE ONE PRODUCT
//    @ApiOperation(value = "Removing product by ID")
//    @DeleteMapping(value = "/products/{id}")
//    @ResponseBody
//    public String delete(@PathVariable long id) {
//        prodServ.deleteProduct(id);
//        return "Product has been deleted successfully";
//    }


    //EDIT PRODUCT
//    @ApiOperation(value = "Editing product info by ID")
//    @PutMapping("/products/{id}")
//    public ResponseEntity<Object> put(@PathVariable(value = "id") int id, @RequestBody Product p) {
//        p.setId(id);
//        Product prod = prodServ.updateProduct(p, id);
//        if (prod == null) {
//            return ResponseEntity.ok().body(new String("Not found"));
//        }
//        return ResponseEntity.ok().body(prod);
//    }

    ////:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::://///////////

	
}
	


