package ae.starzplay.assignment.entity;


import java.util.List;

/**
 * Created by Jagwani on 3/1/2017.
 */

public class MovieMetaData {

        private Xmlns $xmlns;
        private String startIndex;
        private String itemsPerPage;
        private Integer entryCount;
        private String title;
        private List<Entries> entries;

        public Xmlns get$xmlns() {
                return $xmlns;
        }

        public void set$xmlns(Xmlns $xmlns) {
                this.$xmlns = $xmlns;
        }

        public String getStartIndex() {
                return startIndex;
        }

        public void setStartIndex(String startIndex) {
                this.startIndex = startIndex;
        }

        public String getItemsPerPage() {
                return itemsPerPage;
        }

        public void setItemsPerPage(String itemsPerPage) {
                this.itemsPerPage = itemsPerPage;
        }

        public Integer getEntryCount() {
                return entryCount;
        }

        public void setEntryCount(Integer entryCount) {
                this.entryCount = entryCount;
        }

        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public List<Entries> getEntries() {
                return entries;
        }

        public void setEntries(List<Entries> entries) {
                this.entries = entries;
        }

}
