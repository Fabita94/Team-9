package com.bambey2019.myciteuniv;

    public class FriendlyMessage {

        private String id;
        private String text;
        private String name;
        public FriendlyMessage() {
        }

        public FriendlyMessage(String text, String name) {
            this.text = text;
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }


        public String getText() {
            return text;
        }


    }

