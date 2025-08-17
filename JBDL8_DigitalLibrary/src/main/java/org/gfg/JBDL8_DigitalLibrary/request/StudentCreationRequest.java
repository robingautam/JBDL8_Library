package org.gfg.JBDL8_DigitalLibrary.request;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.gfg.JBDL8_DigitalLibrary.annotation.ValidAge;
import org.gfg.JBDL8_DigitalLibrary.model.Address;

@Data
@Builder
public class StudentCreationRequest {

     @NotNull
     String name;
     @NotNull
     String email;
     @NotNull
     String mobileNo;
     @NotNull
     Address address;
     @ValidAge
     String dob;

}
