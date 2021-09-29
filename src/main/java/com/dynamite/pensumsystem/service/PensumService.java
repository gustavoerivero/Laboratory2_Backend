package com.dynamite.pensumsystem.service;

import com.dynamite.pensumsystem.model.Pensum;
import java.util.List;

public interface PensumService {
    public Pensum savePensum(Pensum pensum);
    public List<Pensum> getAllPensum();
    public Pensum getPensumById(int id);
    public Pensum getPensumByCodigo(String codigo);
    public List<Pensum> getAllPensumByPrograma(String codigoPrograma);
    public String updatePensum(Pensum pensum);
    public String deletePensum(int id);
}
