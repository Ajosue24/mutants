package com.mercadolibre.mutants.model.entity;

import com.mercadolibre.mutants.utils.ConstantsTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RecordsDNAEntityTest {


    @Test
    void recordsDNAEntityTest() {
        var recordsDNAEntity = new RecordsDNAEntity(1L, null, Arrays.toString(ConstantsTest.HUMAN_DNA), true);
        var recordsDNAEntitySame = new RecordsDNAEntity(1L, null, Arrays.toString(ConstantsTest.HUMAN_DNA), true);
        assertEquals(recordsDNAEntity, recordsDNAEntitySame);
        assertEquals(recordsDNAEntity.hashCode(), recordsDNAEntitySame.hashCode());
        assertNotNull(recordsDNAEntity.getDna());
        assertNull(recordsDNAEntity.getCreatedAt());
        assertNotNull(recordsDNAEntity.getId());
    }
}
