package Map;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* 梭哈游戏 */
public class demo125 {

	/* 定义扑克牌花色和数值 */
	private static final String[] CARD_TYPES = { "方块", "草花", "红心", "黑桃" };
	private static final String[] CARD_VALUES = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };

	/* 玩家人数 */
	private final int PLAYER_NUM = 5;

	/* 玩家手中的扑克牌组 */
	private List<?>[] playersCards = new List[PLAYER_NUM];

	/* 定义玩家 */
	private String[] players = new String[5];

	/* 定义剩余卡牌 */
	private List<String> cards = new LinkedList<String>();

	public void initCards() {
		for (int i = 0; i < CARD_TYPES.length; i++) {
			for (int j = 0; j < CARD_VALUES.length; j++) {
				this.cards.add(CARD_TYPES[i] + CARD_VALUES[j]);
			}
		}
	}

	/* 初始化扑克牌， 放入52张扑克牌 */
	/* return： 合法性检测 */
	public void initPlayerName(String... name) throws Exception {
		if (name.length > PLAYER_NUM || name.length < 2) {
			throw new Exception("玩家人数不足");
		} else {
			for (int i = 0; i < name.length; i++) {
				this.players[i] = name[i];
			}
		}
	}

	/* 初始化玩家手上的扑克牌 */
	public void initPlayCards() {
		for (int i = 0; i < PLAYER_NUM; i++) {
			/* 玩家有效性检测 */
			if (!(this.players[i] == null) && !this.players[i].equals("")) {
				playersCards[i] = new LinkedList<String>();
			}
		}
	}

	/** 
	 *   @param first 初始被派牌玩家   
	 */
	@SuppressWarnings("unchecked")
	public void deliverCard(String first) {
		/* 调用ArrayUtils 工具类的search方法查询指定元素在数组中的索引 */
		int firstPos = Arrays.binarySearch(this.players, first);
		for (int i = firstPos; i < PLAYER_NUM; i++) {
			if (this.players[i] != null) {
				((LinkedList<String>)playersCards[i]).add(cards.get(0));
				cards.remove(0);
			}
		}
		
		for (int i = 0; i < firstPos; i++) {
			if (players[i] != null) {
				((LinkedList<String>)playersCards[i]).add(cards.get(0));
				cards.remove(0);
			}
		}
	}
	
	/* 输出玩家手上的扑克牌 */ 
	public void showPlayerCards() {
		for (int i = 0; i < PLAYER_NUM; i++) {
			if (players[i] != null) {
				System.out.println(players[i] + ":\t");
				for (Object card: playersCards[i]) {
					System.out.println(card + ", ");
				}
				System.out.println("\n");
			}
		}
	}

	/* 显示所有玩家 和 剩余扑克牌 */
	public void showInfo() {
		/* 玩家 */
		for (String player : players) {
			System.out.println(player);
		}
	}

	public static void main(String[] args) throws Exception {
		demo125 demo = new demo125();
		demo.initCards();
		demo.initPlayerName("playere1", "playere2", "playere3", "playere4", "playere5");
		demo.initPlayCards();
//		demo.showInfo();
		
		demo.deliverCard("playere3");
		demo.showPlayerCards();
		System.out.println(demo.cards);
	}
}
