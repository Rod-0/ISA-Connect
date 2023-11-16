package upc.edu.pe.ISA.Connect.shared.exception;

public class ResourceNotFoundException extends RuntimeException{

            public ResourceNotFoundException() {
                super();
            }

            public ResourceNotFoundException(String message) {
                super(message);
            }
}
