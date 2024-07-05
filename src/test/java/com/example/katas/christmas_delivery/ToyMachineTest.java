package com.example.katas.christmas_delivery;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ToyMachineTest {

    @Mock
    private Elf elf;

    @Mock
    private MrsClaus mrsClaus;

    private ToyMachine toyMachine;

    @BeforeEach
    void setup() {
        toyMachine = new ToyMachine(elf, mrsClaus);
    }

    @Test
    void shouldDeliverToElf() {
        toyMachine.startDelivering();
        ArgumentCaptor<Present> presentCaptor = ArgumentCaptor.forClass(Present.class);
        verify(elf).givesPresent(presentCaptor.capture());
        var present = presentCaptor.getValue();
        assertThat(present.name()).isEqualTo("toy1");
    }

    @Test
    void shouldDeliver50PresentToMrsClaus() {
        toyMachine.startBatchDelivering(50);
        ArgumentCaptor<List<Present>> presentsCaptor = ArgumentCaptor.forClass(List.class);
        verify(mrsClaus).givesPresent(presentsCaptor.capture());
        var presents = presentsCaptor.getValue();
        assertThat(presents).size().isEqualTo(50);
        assertThat(presents.getFirst().name()).isEqualTo("toy1");
        assertThat(presents.getLast().name()).isEqualTo("toy50");
        assertThat(presents.get(18).name()).isEqualTo("toy19");
    }
}