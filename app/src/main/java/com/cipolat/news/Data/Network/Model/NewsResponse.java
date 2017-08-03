package com.cipolat.news.Data.Network.Model;

import java.util.ArrayList;

/**
 * Created by sebastian on 23/07/17.
 */

public class NewsResponse {
    private MainBody response;

    public NewsResponse(MainBody response) {
        this.response = response;
    }

    public MainBody getResponse() {
        return response;
    }

    public void setResponse(MainBody response) {
        this.response = response;
    }

    public class MainBody {
        private String status;
        private int total, startIndex, pageSize, currentPage, pages;
        private ArrayList<Article> results;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getStartIndex() {
            return startIndex;
        }

        public void setStartIndex(int startIndex) {
            this.startIndex = startIndex;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(int currentPage) {
            this.currentPage = currentPage;
        }

        public int getPages() {
            return pages;
        }

        public void setPages(int pages) {
            this.pages = pages;
        }

        public ArrayList<Article> getResults() {
            return results;
        }

        public void setResults(ArrayList<Article> results) {
            this.results = results;
        }
    }
}
