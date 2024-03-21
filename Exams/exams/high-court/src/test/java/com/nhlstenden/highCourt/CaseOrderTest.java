package com.nhlstenden.highCourt;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;


class CaseOrderTest {
    private CaseOrder caseOrder;
    private Client pieter;
    private Inventory blender;
    private Inventory washingMachine;
    private Inventory oven;
    private Inventory coffeeMachine;

    @BeforeEach
    void setUp() {
        pieter = new Client("Pieter", 1200.00);
        caseOrder = new CaseOrder(pieter, 1950.82);
        blender = new Inventory(InventoryType.ELECTRONIC, LocalDate.of(2023, 2, 14));
        washingMachine = new Inventory(InventoryType.KITCHENDEVICE, LocalDate.of(2023, 1, 11));
        oven = new Inventory(InventoryType.KITCHENDEVICE, LocalDate.of(1999, 1, 12));
        coffeeMachine = new Inventory(InventoryType.ELECTRONIC, LocalDate.of(2022, 9, 13));
    }

    @org.junit.jupiter.api.Test
    void calculateTotalItemValueSimpleTest() {
        assertEquals(0.00, caseOrder.calculateTotalItemValue(), "The value is incorrect");
        caseOrder.addItems(blender);
        assertEquals(200.00, caseOrder.calculateTotalItemValue(), "The value is incorrect");
    }

    @org.junit.jupiter.api.Test
    void calculateTotalItemValueAdvancedTest() {
        assertEquals(0.00, caseOrder.calculateTotalItemValue(), "The value is incorrect");
        caseOrder.addItems(blender);
        assertEquals(200.00, caseOrder.calculateTotalItemValue(), "The value is incorrect");
        caseOrder.addItems(washingMachine);
        assertEquals(300.00, caseOrder.calculateTotalItemValue(), "The value is incorrect");
    }

    @org.junit.jupiter.api.Test
    void calculateTotalItemValueDifficultTest() {
        assertEquals(0.00, caseOrder.calculateTotalItemValue(), "The value is incorrect");
        caseOrder.addItems(washingMachine);
        assertEquals(100.00, caseOrder.calculateTotalItemValue(), "The value is incorrect");
        caseOrder.addItems(blender);
        assertEquals(300.00, caseOrder.calculateTotalItemValue(), "The value is incorrect");
        caseOrder.getItems().remove(washingMachine);
        assertEquals(200.00, caseOrder.calculateTotalItemValue(), "The value is incorrect");
        caseOrder.addItems(oven);
        assertEquals(200.00, caseOrder.calculateTotalItemValue(), "The value is incorrect");
    }

    @org.junit.jupiter.api.Test
    void calculateTotalItemValueExtremelyDifficultTest() {
        assertEquals(0.00, caseOrder.calculateTotalItemValue(), "The value is incorrect");
        caseOrder.addItems(washingMachine);
        assertEquals(100.00, caseOrder.calculateTotalItemValue(), "The value is incorrect");
        caseOrder.addItems(blender);
        assertEquals(300.00, caseOrder.calculateTotalItemValue(), "The value is incorrect");
        caseOrder.getItems().remove(washingMachine);
        caseOrder.getItems().remove(blender);
        assertEquals(0.00, caseOrder.calculateTotalItemValue(), "The value is incorrect");
        caseOrder.addItems(oven);
        assertEquals(0.00, caseOrder.calculateTotalItemValue(), "The value is incorrect");
        caseOrder.addItems(blender);
        caseOrder.addItems(washingMachine);
        caseOrder.addItems(oven);
        caseOrder.addItems(coffeeMachine);
        assertEquals(500.00, caseOrder.calculateTotalItemValue(), "The value is incorrect");
    }
}