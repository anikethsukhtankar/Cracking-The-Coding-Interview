package SortingAndSearching;

public class RankFromStream {
    RankNode root = null;

    static class RankNode{
        int data;
        int leftSize;
        RankNode left, right;

        RankNode(int d){
            data = d;
        }

        void insert(int d){
            if(d < data){
                if(left == null)
                    left = new RankNode(d);
                else
                    left.insert(d);
                leftSize++;
            }
            else{
                if(right == null)
                    right = new RankNode(d);
                else
                    right.insert(d);
            }
        }

        int getRank(int d){
            if(data == d)
                return leftSize;
            else if (d < data)
                return left.getRank(d);
            else{
                int rightRank = (right == null) ? -1:right.getRank(d);
                if(rightRank == -1) return -1;
                return leftSize + 1 + rightRank;
            }
        }
    }

    public void track(int d){
        if(root == null)
            root = new RankNode(d);
        else
            root.insert(d);
    }

    public int getRank(int d){
        return root.getRank(d);
    }

    public static void main(String[] args) {
        RankFromStream rs = new RankFromStream();
        rs.track(20);
        rs.track(15);
        rs.track(25);
        rs.track(10);
        rs.track(23);
        rs.track(5);
        rs.track(13);
        rs.track(24);
        System.out.println(rs.getRank(24));
    }
}
