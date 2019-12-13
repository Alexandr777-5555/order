package area.answers;

import area.validator.register.Product;

/**
 * Должен быть статус ответа
 * <p>
 * <p>
 * мы же будем запрашивать продукты значит их может не быть или быть и сколько
 */
public class Answer {

    private Product product;
    private Status status;
    private ProductError error;


    public Answer(Product product, Status status, ProductError error) {
        this.product = product;
        this.status = status;
        this.error = error;
    }



    public enum Status {
        YES, NO, ERROR
    }


    public static class ProductError{
        private String code; // код ошибки
        private String text; // текст

        public ProductError(String code, String text) {
            this.code = code;
            this.text = text;
        }

        public String getCode() {
            return code;
        }

        public String getText() {
            return text;
        }
    }


    public Product getProduct() {
        return product;
    }

    public Status getStatus() {
        return status;
    }

    public ProductError getError() {
        return error;
    }
}
