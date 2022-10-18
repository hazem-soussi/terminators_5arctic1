package com.esprit.examen.TestService;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.esprit.examen.controllers.ProduitRestController;
import com.esprit.examen.entities.Produit;
import com.esprit.examen.repositories.ProduitRepository;
import com.esprit.examen.services.ProduitServiceImpl;


import java.util.ArrayList;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;


import java.util.List;
import java.util.Optional;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.InjectMocks;
import org.junit.Before;


@WebMvcTest(value= ProduitRestController.class)
//@ExtendWith(MockitoExtension.class)
//@RunWith(SpringRunner.class)
public class TestProductService {
	
	
	@InjectMocks
	private ProduitServiceImpl productService;
	
	
	@Mock
	private ProduitRepository productRepo;

	
	 @Before
	    public void setUp() {

	        Produit product = new Produit("a","a");
	        product.setCodeProduit("iPhone 10");
	        product.setIdProduit(1L);
	        Produit product1 = new Produit("a","a");
	        product1.setCodeProduit("alpha");
	        product1.setIdProduit(2L);

	        Mockito.when(productRepo.findById(product.getIdProduit())).thenReturn(Optional.of(product));

	        List<Produit> products = new ArrayList<Produit>();
	        products.add(product);
	        products.add(product1);

	        Mockito.when(productRepo.
	                findAll()).thenReturn(products);
	    }

	    @Test void getAllProducts()
	    {
	        productService.getAll();
	        verify(productRepo).findAll();
	    }

	    @Test
	    public void addProd() {

	    	Produit prod = new Produit("a","a");
	        prod.setIdProduit(2L);
	        prod.setCodeProduit("iPhone 10");
	        productService.addProduit(prod);
	        verify(productRepo, times(1)).save(prod);
	    }

//	    @Test
	//
//	     void testUpdateProduct() throws Exception {
//	        Product product = productRepo.findByTitle("iPhone 10");
//	        product.setDescription("New");
//	        System.out.println(product);
//	        productService.updateProduct(product,product.getId());
	//
//	        Product updatedProduct = productRepo.findByTitle("iPhone 10");
	//
//	        assertThat(updatedProduct.getDescription()).isEqualTo("New");
//	    }
	//



	        @Test
	         void whenGivenId_shouldDeleteUser_ifFound(){
	            Produit prod = new Produit("a","a");
	            prod.setCodeProduit("Test Name");
	            prod.setIdProduit(1L);

	            when(productRepo.findById(prod.getIdProduit())).thenReturn(Optional.of(prod));

	            productService.deleteProduit(prod.getIdProduit());
	            verify(productRepo).deleteById(prod.getIdProduit());
	        }

	        @Test
	         void should_throw_exception_when_user_doesnt_exist() {
	        	Produit user = new Produit("a","a");
	            user.setIdProduit(89L);
	            user.setCodeProduit("Test Name");

	            given(productRepo.findById(anyLong())).willReturn(Optional.ofNullable(null));
	            productService.deleteProduit(user.getIdProduit());
	        }



//	    @Test
//	     void whenGivenId_shouldUpdateUser_ifFound() throws Exception {
//	        Product prod = new Product();
//	        prod.setId(89L);
//	        prod.setTitle("Test Name");
	//
//	        Product newProd = new Product();
//	        prod.setTitle("New Test Name");
	//
//	        given(productRepo.findById(prod.getId())).willReturn(Optional.of(prod));
//	        productService.updateProduct(newProd, prod.getId());
	//
//	        verify(productRepo).save(newProd);
//	        verify(productRepo).findById(prod.getId());
//	    }
	//




	    @Test
	    public void should_throw_exception_when_user_doesnt_exist1() {
	        Produit user = new Produit("a","a");
	        user.setIdProduit(89L);
	        user.setCodeProduit("Test Name");

	        Produit newUser = new Produit("a","a");
	        newUser.setIdProduit(90L);
	        user.setCodeProduit("New Test Name");

	        given(productRepo.findById(anyLong())).willReturn(Optional.ofNullable(null));
//	        productService.updateProduct(prod.getId(), newUser);
	    }


}
