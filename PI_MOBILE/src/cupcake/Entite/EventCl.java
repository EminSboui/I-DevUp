/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cupcake.Entite;

/**
 *
 * @author Asus
 */
public class EventCl {
    private Event event;
    private User client;

    public EventCl(Event event, User client) {
        this.event = event;
        this.client = client;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "EventCl{" + "event=" + event + ", client=" + client + '}';
    }
    
    
}
