package com.example.katas.bank_ocr;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KataBankOCRTest {

    private KataBankOCR kataBankOCR;
    @BeforeEach
    void setup(){
        kataBankOCR = new KataBankOCR();
    }

    @Test
    void shouldConvertOne(){
        var input = "    _  _     _  _  _  _  _  _ \n"
                + "  | _| _||_||_ |_   ||_||_|| |\n"
                + "  ||_  _|  | _||_|  ||_| _||_|\n";
        kataBankOCR.convert(input);
    }

}