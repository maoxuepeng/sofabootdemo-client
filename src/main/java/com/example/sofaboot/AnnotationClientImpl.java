package com.example.sofaboot;

import com.alipay.sofa.runtime.api.annotation.SofaReference;
import com.alipay.sofa.runtime.api.annotation.SofaReferenceBinding;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AnnotationClientImpl {
    @SofaReference(interfaceType = AnnotationService.class, jvmFirst = false,
            binding = @SofaReferenceBinding(bindingType = "bolt"))
    private AnnotationService annotationService;
    public String sayClientAnnotation(String str) {
        return annotationService.sayAnnotation(str);
    }
}
