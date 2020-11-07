package edu.eci.cvds.model.dao;

import edu.eci.cvds.model.entities.element.ElementHistory;
import org.apache.ibatis.exceptions.PersistenceException;

import java.util.List;

@SuppressWarnings("unused")
public interface ElementHistoryDAO {

    void addElementHistoryById(long elementId, long userId, String title) throws PersistenceException;

    void addElementHistoryWithDetailById(long elementId, long userId, String title, String detail) throws PersistenceException;

    void addElementHistoryByReference(String reference, long userId, String title) throws PersistenceException;

    void addElementHistoryByReferenceAndUsername(String reference, String username, String title) throws PersistenceException;

    void addElementHistoryWithDetailByReference(String reference, long userId, String title, String detail) throws PersistenceException;

    List<ElementHistory> loadElementsHistory() throws PersistenceException;

    List<ElementHistory> loadElementHistoryById(long elementId) throws PersistenceException;
}