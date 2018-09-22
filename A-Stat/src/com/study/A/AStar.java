package com.study.A;

/**
 * A*寻路算法
 * <pre>
 * 思路：	每次取期望值最小的位置作为下一步要走的位置，F = G + H
 *  	G 表示从起点 A 移动到网格上指定方格的移动耗费 (可沿斜方向移动,斜方向的代价为对角线长度).
 *  	H 表示从指定的方格移动到终点 B 的预计耗费 (H 有很多计算方法, 这里我们设定只可以上下左右移动).
 *
 *  	此处用一个最小堆来记录开启列表中的格子，每个格子有一个指向父格子的指针，以此记录路劲 </pre>
 */
public class AStar {

    private static MinHeap<Grid> open ;//= new MinHeap<Grid>();
    //	private static MTree close ;//= new MTree();
    private Grid last; //记录最后一个格子

    private final String obstacle = "1";//障碍物标记值
    private String end = "e";	////目标标记值
    private String start = "s";////开始标记值
    //目标坐标
    private int end_i = -1;
    private int end_j = -1;
    //开始目标
    private int start_i = -1;
    private int start_j = -1;

    /**
     * 初始化操作
     * @param boxs
     */
    public void init(String[][] boxs){
        for(int i=0;i<boxs.length;i++){
            for(int j=0;j<boxs[0].length;j++){
                if(boxs[i][j].equals(start)){
                    start_i = i;
                    start_j = j;
                }
                if(boxs[i][j].equals(end)){
                    end_i = i;
                    end_j = j;
                }
            }
        }

        Grid sGrid = new Grid(0, 0, 0, start_i, start_j, null);
        open = new MinHeap<Grid>();
        open.append(sGrid);///、将开始位置加入开集
    }
    /**
     * 开始搜索
     */
    public void search(String[][] boxs){
        int height = boxs.length;
        int width = boxs[0].length;
        while(open.peek()!=null){//对开集进行遍历，直到找到目标或者找不到通路
            Grid g = open.poll();
            int i = g.getI();
            int j = g.getJ();
            double pre_G = g.getG();///已耗费
            for(int h=-1;h<=1;h++){
                for(int w=-1;w<=1;w++){

                    int next_i = i + h;	///下一个将加入open 集的格子的i
                    int next_j = j + w;///下一个将加入open 集的格子的j

                    if(next_i>=0 && next_i<=height-1 && next_j>=0 && next_j<=width-1){
                        ////数组不越界，则进行计算
                        if(boxs[next_i][next_j].equals(obstacle) || boxs[next_i][next_j].equals("-1") ||(h==0&&w==0)){
                            //如果该格子是障碍，或者格子本身，跳过
                            continue;
                        }
                        ////计算该点到终点的最短路劲
                        double H =  Math.abs(end_i - next_i) + Math.abs(end_j - next_j) ;
                        if(H<1){
                            ///找到目标,记录并结束
                            last = new Grid(0, pre_G, 0, next_i, next_j,g); ;
                            return ;
                        }
                        ////如果是对角线则加1.4，否则加1
                        double G = Math.sqrt((next_i-i)*(next_i-i)+(next_j-j)*(next_j-j))>1 	? 	pre_G+1.4 	: 	pre_G+1;
                        //生成新格子
                        Grid temp = new Grid(H+G, G, H, next_i, next_j,g);
                        ////加入open集
                        open.append(temp);
                        boxs[i][j] = "-1";///表示此处已经计算过了
                    }
                }
            }

            last = g;
        }


    }

    /**
     * 打印路劲
     */
    public void printPath(){

        if(end_i!=last.getI()||end_j!=last.getJ()){
            System.out.println("无法到达终点！");
            return ;
        }

        System.out.println("路径逆序为:");
        while(true){
            System.out.print("("+last.getI()+","+last.getJ()+")");
            last = last.getParent();
            if(last==null){
                break;
            }
            System.out.print(" <———");
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
		/*Grid g1 = new Grid(2, 1, 2, 0, 0,null);
		Grid g2 = new Grid(5, 1, 2, 0, 0,g1);
		Grid g3 = new Grid(1, 1, 2, 0, 0,g1);
		Grid g4 = new Grid(6, 1, 2, 0, 0,g2);
		Grid g5 = new Grid(3, 1, 2, 0, 0,g3);

		open = new MinHeap<Grid>();
		open.append(g1);
		open.append(g2);
		open.append(g3);
		open.append(g4);
		open.append(g5);
		//、测试最小堆
		while(null!=open.peek()){
			System.out.println(open.poll().getF());
		}
		*/
        String[][] boxs = {//{"0","g"},{"s","0"}};
                {"0","0","1","0","0"},
                {"0","0","1","e","0"},
                {"0","0","1","1","0"},
                {"0","0","0","1","0"},
                {"s","0","1","0","0"},
        };

        AStar star = new AStar();
        star.init(boxs);
        star.search(boxs);
        star.printPath();
    }

}
