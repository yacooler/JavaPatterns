package composite;


import memento.Memento;

public abstract class BaseControlObject implements BaseControl, Memento {

    protected Rectangle bounds  = new Rectangle(0,0,0,0);
    protected String text;
    protected boolean enabled;

    @Override
    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }

    @Override
    public boolean checkBounds(Point point) {
        return bounds.isPointInBounds(point);
    }

    @Override
    public void move(Point newPos) {
        this.bounds.setX(newPos.getX());
        this.bounds.setY(newPos.getY());
    }

    @Override
    public void scale(Float scl) {
        this.bounds = new Rectangle(
                Math.round(bounds.getX() * scl),
                Math.round(bounds.getY() * scl),
                Math.round(bounds.width * scl),
                Math.round(bounds.getHeight() * scl));
    }


    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public Rectangle getBounds() {
        return bounds;
    }

    @Override
    public void draw() {
        this.draw(new Point(0, 0));
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    @Override
    public String serializeObject() {
        return baseSerialize();
    }

    @Override
    public void deserializeObject(String serialized) {
        baseDeserialize(serialized);
    }

    protected String baseSerialize() {
        StringBuilder builder = new StringBuilder();
        return builder.append("text:").append("\"").append(this.text).append("\",")
                .append("enabled:").append(this.enabled).append(",")
                .append("bounds.x:").append(this.bounds.getX()).append(",")
                .append("bounds.y:").append(this.bounds.getY()).append(",")
                .append("bounds.width:").append(this.bounds.getWidth()).append(",")
                .append("bounds.height:").append(this.bounds.getHeight())
                .toString();
    }

    protected String baseDeserialize(String serializedObject) {
        String[] values = serializedObject.split(",");
        String[] param = new String[2];
        StringBuilder builder = new StringBuilder();
        for (String value : values) {
            param[0] = value.substring(0, value.indexOf(":"));
            param[1] = value.substring(value.indexOf(":") + 1);
            switch (param[0]) {
                case "text" -> this.text = param[1].substring(1, param[1].length() - 1);
                case "enabled" -> this.enabled = param[1].equalsIgnoreCase("true");
                case "bounds.x" -> this.bounds.setX(Integer.parseInt(param[1]));
                case "bounds.y" -> this.bounds.setY(Integer.parseInt(param[1]));
                case "bounds.width" -> this.bounds.setWidth(Integer.parseInt(param[1]));
                case "bounds.height" -> this.bounds.setHeight(Integer.parseInt(param[1]));
                default -> {
                    //Если не смогли что-то обработать - отдадим на обработку потомкам
                    if (builder.length() > 0) builder.append(",");
                    builder.append(value);
                }
            }
        }
        return builder.toString();
    }


}
