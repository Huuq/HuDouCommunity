package club.qh.web.dto;

import java.util.ArrayList;
import java.util.List;

public class PaginationDTO {
    private List<QuestionDTO> question;
    private boolean showPrevious = true;
    private boolean showFirstPage = true;
    private boolean showNextPage = true;
    private boolean showEndPage = true;
    private Integer page;
    private List<Integer> pages = new ArrayList<Integer>();
    private Integer totalPage;
    
    
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public List<Integer> getPages() {
		return pages;
	}
	public void setPages(List<Integer> pages) {
		this.pages = pages;
	}
	public List<QuestionDTO> getQuestion() {
		return question;
	}
	public void setQuestion(List<QuestionDTO> question) {
		this.question = question;
	}
	public boolean isShowPrevious() {
		return showPrevious;
	}
	public void setShowPrevious(boolean showPrevious) {
		this.showPrevious = showPrevious;
	}
	public boolean isShowFirstPage() {
		return showFirstPage;
	}
	public void setShowFirstPage(boolean showFirstPage) {
		this.showFirstPage = showFirstPage;
	}
	public boolean isShowNextPage() {
		return showNextPage;
	}
	public void setShowNextPage(boolean showNextPage) {
		this.showNextPage = showNextPage;
	}
	public boolean isShowEndPage() {
		return showEndPage;
	}
	public void setShowEndPage(boolean showEndPage) {
		this.showEndPage = showEndPage;
	}
	public void setPagination(Integer totalCount, Integer page, Integer size) {
		if(totalCount % size ==0) {
			totalPage = totalCount/size;
		}else {
			totalPage = totalCount/size+1;
		}
		if(page < 1) {
			page = 1;
		}
		if(page >totalPage) {
			page = totalPage;
		}
		this.page = page;
		pages.add(page);
		for(int i = 1;i <=3;i++) {
			if(page-i >0) {
				pages.add(0,page-1);
			}
			else if(page + i <= totalPage) {
				pages.add(page+i);
			}
		}
		if(page == 1) {
			showPrevious = false;
		}else {
			showNextPage =true;
		}
		
		if(pages.contains(1)) {
			showFirstPage = false;
		}else {
			showFirstPage = true;
		}
		if(pages.contains(totalPage)) {
			showEndPage = false;
		}else {
			showEndPage = true;
		}
		
		// TODO Auto-generated method stub
		
	}
   
   
}
