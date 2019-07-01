import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public final class Graphics {
    public static void draw(Island island, Group root) {
//        StackPane pane = new StackPane();
//        root.getChildren().add(pane);
        double theta = 2 * Math.PI / island.getNodes().size();
        List<Pair<Double, Double>> coord = new ArrayList<>();
        for (int i = 0; i < island.getNodes().size(); i++) {
            coord.add(coordinator(i * theta, 700, 400));
        }
        for (Pair<Node, Node> nodes : island.getLinks()) {
            Line line =
                    new Line(coord.get(nodes.getKey().getNumber() - 1).getKey(),
                            coord.get(nodes.getKey().getNumber() - 1).getValue(),
                            coord.get(nodes.getValue().getNumber() - 1).getKey(),
                            coord.get(nodes.getValue().getNumber() - 1).getValue());
            root.getChildren().add(line);
        }
        for (int i = 0; i < coord.size(); i++) {
            Circle circle = new Circle(coord.get(i).getKey(),
                    coord.get(i).getValue(), 20);
            Label label = new Label(String.valueOf(i + 1));
            label.setTranslateX(coord.get(i).getKey());
            label.setTranslateY(coord.get(i).getValue());
            label.setFont(Font.font("Pristina", FontWeight.BOLD,
                    FontPosture.ITALIC, 35));
            if (island.getNodes().get(i).getNodeType() == NodeType.AIRPORT) {
                circle.setFill(Color.CYAN);
            } else if (island.getNodes().get(i).getNodeType() == NodeType.CAFE) {
                circle.setFill(Color.CRIMSON);
            }
            root.getChildren().addAll(circle, label);
        }
    }

    private static Pair<Double, Double> coordinator(double t, int h, int w) {
        Double x = (h - 400) * Math.cos(t) - (w - 400) * Math.sin(t) + 400;
        Double y = (h - 400) * Math.sin(t) + (w - 400) * Math.cos(t) + 400;
        return new Pair<>(x, y);
    }
}
