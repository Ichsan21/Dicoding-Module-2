package com.rizky92.latihanmvvm;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MainViewModelTest {
    private MainViewModel mainViewModel;
    private CuboidModel cuboidModel;

    private final double dLength = 10.0;
    private final double dWidth = 15.0;
    private final double dHeight = 12.5;

    private final double dVol = 1875.0;
    private final double dCirc = 150.0;
    private final double dSurf = 925.0;

    @Before
    public void before() {
        cuboidModel = mock(CuboidModel.class);
        mainViewModel = new MainViewModel(cuboidModel);
    }

    @Test
    public void testVolume() {
        cuboidModel = new CuboidModel();
        mainViewModel = new MainViewModel(cuboidModel);
        mainViewModel.save(dLength, dWidth, dHeight);
        double vol = mainViewModel.getVolume();
        assertEquals(dVol, vol, 0.0001);
    }

    @Test
    public void testCircumference() {
        cuboidModel = new CuboidModel();
        mainViewModel = new MainViewModel(cuboidModel);
        mainViewModel.save(dLength, dWidth, dHeight);
        double circ = mainViewModel.getCircumference();
        assertEquals(dCirc, circ, 0.0001);
    }

    @Test
    public void testSurfaceArea() {
        cuboidModel = new CuboidModel();
        mainViewModel = new MainViewModel(cuboidModel);
        mainViewModel.save(dLength, dWidth, dHeight);
        double surf = mainViewModel.getSurfaceArea();
        assertEquals(dSurf, surf, 0.0001);
    }

    @Test
    public void testMockVolume() {
        when(mainViewModel.getVolume()).thenReturn(dVol);
        double vol = mainViewModel.getVolume();
        verify(cuboidModel).getVolume();
        assertEquals(dVol, vol, 0.0001);
    }

    @Test
    public void testMockCurcumference() {
        when(mainViewModel.getCircumference()).thenReturn(dCirc);
        double circ = mainViewModel.getCircumference();
        verify(cuboidModel).getCircumference();
        assertEquals(dCirc, circ, 0.0001);
    }

    @Test
    public void testMockSurfaceArea() {
        when(mainViewModel.getSurfaceArea()).thenReturn(dSurf);
        double surf = mainViewModel.getSurfaceArea();
        verify(cuboidModel).getSurfaceArea();
        assertEquals(dSurf, surf, 0.0001);
    }

    @Test
    public void save() {
    }

    @Test
    public void getCircumference() {
    }

    @Test
    public void getSurfaceArea() {
    }

    @Test
    public void getVolume() {
    }
}