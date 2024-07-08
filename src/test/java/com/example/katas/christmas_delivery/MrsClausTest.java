package com.example.katas.christmas_delivery;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

class MrsClausTest {

    @Test
    void shouldGiveAllPresents() throws InterruptedException {
        var elfFactory = mock(ElfFactory.class);
        var elf = mock(Elf.class);
        var familyRepository = mock(FamilyInMemoryRepository.class);
        when(elfFactory.createElf()).thenReturn(elf);
        var mrsClaus = new MrsClaus(elfFactory, familyRepository, 10);
        var presents = createPresents(10);

        CountDownLatch countDownLatch = new CountDownLatch(presents.size());
        doAnswer(invocationOnMock -> {
            countDownLatch.countDown();
            return null;
        }).when(elf).givesPresent(any(Present.class));

        mrsClaus.givesPresent(presents);

        boolean allThreadsFinished = countDownLatch.await(3, TimeUnit.SECONDS);
        assertThat(allThreadsFinished).isTrue();

        ArgumentCaptor<Present> presentArgumentCaptor = ArgumentCaptor.forClass(Present.class);
        verify(elf, times(presents.size())).givesPresent(presentArgumentCaptor.capture());
        var capturedPresents = presentArgumentCaptor.getAllValues();
        assertThat(capturedPresents).hasSize(10);
        assertThat(capturedPresents.stream().map(Present::name).filter(name -> name.equals("toy1")).findAny()).isPresent();
    }

    private List<Present> createPresents(int presentsNumber) {
        return IntStream
                .range(0, presentsNumber)
                .mapToObj(a -> new Present("toy" + (a + 1)))
                .toList();
    }


}