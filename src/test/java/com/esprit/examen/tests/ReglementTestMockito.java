package com.esprit.examen.tests;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.esprit.examen.entities.Reglement;
import com.esprit.examen.repositories.ReglementRepository;
import com.esprit.examen.services.ReglementServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ReglementTestMockito {


    @Mock
    private ReglementRepository rr;

    @InjectMocks
    private ReglementServiceImpl rsi;
    
    
    

    @Before
    public void setUp() {

        Reglement reg = new Reglement();
        reg.setIdReglement(50L);
        reg.setMontantPaye(12);
        Reglement reg1 = new Reglement();
        reg1.setIdReglement(60L);
        reg1.setMontantPaye(2);

        Mockito.when(rr.findById(reg.getIdReglement())).thenReturn(Optional.of(reg));

        List<Reglement> regs = new ArrayList<Reglement>();
        regs.add(reg);
        regs.add(reg1);

        Mockito.when(rr.findAll()).thenReturn(regs);
    }
    
    
    @Test
    void getAllProducts()
    {
        rsi. retrieveAllReglements();
        verify(rr).findAll();
    }

    @Test
    public void addProd() {

        Reglement reg = new Reglement();
        reg.setIdReglement(5L);
        reg.setMontantPaye(20);
        rsi.addReglement(reg);
        verify(rr, times(1)).save(reg);
    }
}

