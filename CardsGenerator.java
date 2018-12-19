public class CardsGenerator{

	private int cardsNumbers;	//卡牌数
	private int minScale;		//卡牌下界
	private int maxScale;		//卡牌上界
	private int[] cardsValue;   //卡牌值
	private int[] cardsColor;   //卡牌花色
	CardsGenerator(){
		this(4,1,13);
	}
	CardsGenerator(int num){
		this(num,1,13);
	}
	CardsGenerator(int num,int max){
		this(num,1,max);
	}	
	CardsGenerator(int num, int min, int max){
		this.cardsNumbers = num;
		this.minScale = min;
		this.maxScale = max;
		this.cardsValue = new int[num];
		this.cardsColor = new int[num];
	}

	public void setCardsNum(int num){
		this.cardsNumbers = num;
	}
	public void setMinScale(int min){
		this.minScale = min;
	}
	public void setMaxScale(int max){
		this.maxScale = max;
	}
	public void setScales(int min, int max){
		setMinScale(min);
		setMaxScale(max);
	}
	
	public int getCardsNum(){
		return this.cardsNumbers;
	}
	public int getMinScale(){
		return this.minScale;
	}
	public int getMaxScale(){
		return this.maxScale;
	}
	
	public int[] getCards(){
		return this.cardsValue;
	}
	public int[] getCardsColor(){
		return this.cardsColor;
	}
	//调用随机函数生成卡牌的的值
	public int[] randomCards(){
		for(int i=0;i<this.cardsNumbers;i++){
			double temp = Math.random()*this.maxScale;
			this.cardsValue[i] = this.minScale + (int)temp;
		}
		return this.cardsValue;
	}
	public int[] randomCardsColor(){
		for(int i=0;i<this.cardsNumbers;i++){
			int temp = 1+(int)(Math.random()*4);
				this.cardsColor[i] = temp;
		}
		return this.cardsColor;
	}

}
