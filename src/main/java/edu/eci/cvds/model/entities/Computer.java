package edu.eci.cvds.model.entities;

import edu.eci.cvds.model.entities.element.Element;
import edu.eci.cvds.model.entities.element.type.ElementTypeName;

import java.io.Serializable;

@SuppressWarnings("unused")
public class Computer implements Serializable {

    private long id;
    private String reference;
    private Element computerCase;
    private Element monitor;
    private Element keyboard;
    private Element mouse;
    private boolean available;
    private boolean discarded;

    public Element getElement(ElementTypeName typeName) {
        switch (typeName) {
            case ETN_COMPUTER_CASE:
                return computerCase;
            case ETN_MONITOR:
                return monitor;
            case ETN_KEYBOARD:
                return keyboard;
            case ETN_MOUSE:
                return mouse;
            default:
                return null;
        }
    }

    public Computer() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Element getComputerCase() {
        return computerCase;
    }

    public void setComputerCase(Element computerCase) {
        this.computerCase = computerCase;
    }

    public Element getMonitor() {
        return monitor;
    }

    public void setMonitor(Element monitor) {
        this.monitor = monitor;
    }

    public Element getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(Element keyboard) {
        this.keyboard = keyboard;
    }

    public Element getMouse() {
        return mouse;
    }

    public void setMouse(Element mouse) {
        this.mouse = mouse;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isDiscarded() {
        return discarded;
    }

    public void setDiscarded(boolean discarded) {
        this.discarded = discarded;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "id=" + id +
                ", reference='" + reference + '\'' +
                ", computerCase=" + computerCase +
                ", monitor=" + monitor +
                ", keyboard=" + keyboard +
                ", mouse=" + mouse +
                ", available=" + available +
                ", discarded=" + discarded +
                '}';
    }
}