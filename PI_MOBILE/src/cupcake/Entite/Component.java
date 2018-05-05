package cupcake.Entite;

/**
 *
 * @author Dorra
 */
public class Component {
    private int componentId;
    private String componentname;
    private int quantity;
    private int recipeid;
    private String unity;

    public Component(int componentId, String componentname, int quantity, String unity) {
        this.componentId = componentId;
        this.componentname = componentname;
        this.quantity = quantity;
        this.unity = unity;
    }
    

    public Component(int componentId, String componentname, int quantity) {
        this.componentId = componentId;
        this.componentname = componentname;
        this.quantity = quantity;
    }
    
    public Component(String componentname, int quantity, String unity) {
        this.componentname = componentname;
        this.quantity = quantity;
        this.unity = unity;
    }

    public Component(String componentname, int quantity,String unity, int recipeid) {
        this.componentname = componentname;
        this.quantity = quantity;
        this.unity = unity;
        this.recipeid = recipeid;
    }

    public Component(String componentname, int quantity) {
        this.componentname = componentname;
        this.quantity = quantity;
    }

    public Component() {
    }

    public int getComponentId() {
        return componentId;
    }

    public void setComponentId(int componentId) {
        this.componentId = componentId;
    }

    public String getComponentname() {
        return componentname;
    }

    public void setComponentname(String componentname) {
        this.componentname = componentname;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Composant : " + componentname + ", Quantité " + quantity +"\n";
    }   

    public int getRecipeid() {
        return recipeid;
    }

    public void setRecipeid(int recipeid) {
        this.recipeid = recipeid;
    }

    public String getUnity() {
        return unity;
    }

    public void setUnity(String unity) {
        this.unity = unity;
    }
}