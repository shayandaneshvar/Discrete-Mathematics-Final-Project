import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;
/*
    K = Number of Islands
    F = First Position in the N(th) place
    J = First Position in the K(th) place

    N = Number of Places in Each Island
    M = Number of Relations Available between Places in each Island
    S = Number of the place With aeroplanes in each Island
    T = Number of the place which is Going to be Robbed

Next M Lines:
       U,V : two numbers in each line which indicates that place U is connected To place V
*/

/**
 * @author S.Shayan Daneshvar
 * @author Hashem Pourallahverdi
 */

public class Main extends Application {
    public static void main(String[] args) {
        // K,F,J
        int numberOfIslands, initialNode, initialIsland;
        Scanner scanner = new Scanner(System.in);
        List<Island> islands = new ArrayList<>();
        numberOfIslands = scanner.nextInt();
        initialNode = scanner.nextInt();
        initialIsland = scanner.nextInt();
        for (int i = 0; i < numberOfIslands; i++) {
            int numberOfPlaces = scanner.nextInt();
            int numOfRelations = scanner.nextInt();
            int airplane = scanner.nextInt();
            int cafe = scanner.nextInt();
            List<Node> nodes = new ArrayList<>();
            List<Pair<Node, Node>> links = new ArrayList<>();
            for (int j = 0; j < numberOfPlaces; j++) {
                if (j == airplane) {
                    nodes.add(new Node(j + 1, NodeType.AIRPORT));
                } else if (j == cafe) {
                    nodes.add(new Node(j + 1, NodeType.CAFE));
                } else {
                    nodes.add(new Node(j + 1, NodeType.NORMAL));
                }
            }
            for (int j = 0; j < numOfRelations; j++) {
                int node1 = scanner.nextInt();
                int node2 = scanner.nextInt();
                links.add(new Pair<>(nodes.stream().filter(x -> x.
                        getNumber() == node1).collect(Collectors.toList()).
                        get(0), nodes.stream().filter(x -> x.getNumber() ==
                        node2).collect(Collectors.toList()).get(0)));
                ;
            }
            islands.add(new Island(nodes, links, i + 1));
        }
        int cost = 0;
        Island initIsland = islands.stream().filter(x -> x.getNumber() ==
                initialIsland).collect(Collectors.toList()).get(0);
        islands.remove(initIsland);
        cost += handleIsland(initIsland,
                initIsland.getNodes().stream().filter(x -> x.getNumber() ==
                        initialNode).collect(Collectors.toList()).get(0));
        for (Island island : islands) {
            cost += handleIsland(island, island.getAirport());
        }
        System.out.println(cost);
//        launch(args);
    }

    private static int handleIsland(Island island, Node startPalce) {
        int pathLength = 0;
        pathLength += bfs(island, startPalce, island.getCafe());
        pathLength += bfs(island, island.getCafe(), island.getAirport());
        return pathLength;
    }


    private static int bfs(Island island, Node start, Node end) {
        Integer depth = 0;
        Node curNode = start;
        Queue<Node> curNodes = new LinkedList<>();
        curNodes.add(curNode);
        curNodes.add(new Node(-1, NodeType.NORMAL));
        while (curNode.getNumber() != end.getNumber()) {
            int temp = curNode.getNumber();
            curNode = goToNextNodes(curNode, island.getLinks().stream().filter(
                    x -> x.getKey().getNumber() == temp || x.getValue().
                            getNumber() == temp).collect(Collectors.toList())
                    , curNodes, depth);
        }
        return depth;
    }

    private static Node goToNextNodes(Node curNode,
                                      List<Pair<Node,Node>> links,
                                      Queue<Node> curNodes, Integer depth) {
        if(curNodes.peek().getNumber() == -1) {
            depth++;
        }
        curNodes.poll();
        for (Pair<Node,Node> link:links) {
            if(link.getValue().getNumber() != curNode.getNumber()) {
                curNodes.add(link.getValue());
            } else {
                curNodes.add(link.getKey());
            }

        }
        return curNodes.peek();
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        //todo
    }
}