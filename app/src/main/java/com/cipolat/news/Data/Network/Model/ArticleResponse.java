package com.cipolat.news.Data.Network.Model;

/**
 * Created by sebastian on 23/07/17.
 */

public class ArticleResponse {
    private Response response;

    public ArticleResponse(Response response) {
        this.response = response;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }


    public class Response {
        private String status;
        private int total;
        private Article content;

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

        public Article getContent() {
            return content;
        }

        public void setContent(Article content) {
            this.content = content;
        }
    }
}
