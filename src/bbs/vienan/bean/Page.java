package bbs.vienan.bean;

public class Page {
	// 1.ÿҳ��ʾ����(everyPage)
	private int everyPage;
	// 2.�ܼ�¼��(totalCount)
	private int totalCount;
	// 3.��ҳ��(totalPage)
	private int totalPage;
	// 4.��ǰҳ(currentPage)
	private int currentPage;
	// 5.��ʼ��(beginIndex)
	private int beginIndex;
	// 6.�Ƿ�����һҳ(hasPrePage)
	private boolean hasPrePage;
	// 7.�Ƿ�����һҳ(hasNextPage)
	private boolean hasNextPage;

	public Page(int everyPage, int totalCount, int totalPage, int currentPage,
			int beginIndex, boolean hasPrePage, boolean hasNextPage) {
		this.everyPage = everyPage;
		this.totalCount = totalCount;
		this.totalPage = totalPage;
		this.currentPage = currentPage;
		this.beginIndex = beginIndex;
		this.hasPrePage = hasPrePage;
		this.hasNextPage = hasNextPage;
	}

	//���캯��Ĭ��
	public Page(){}
	
	//���췽�������������Խ�������
	
	
	public int getEveryPage() {
		return everyPage;
	}

	public void setEveryPage(int everyPage) {
		this.everyPage = everyPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getBeginIndex() {
		return beginIndex;
	}

	public void setBeginIndex(int beginIndex) {
		this.beginIndex = beginIndex;
	}

	public boolean isHasPrePage() {
		return hasPrePage;
	}

	public void setHasPrePage(boolean hasPrePage) {
		this.hasPrePage = hasPrePage;
	}

	public boolean isHasNextPage() {
		return hasNextPage;
	}

	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}

}
