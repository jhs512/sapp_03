package com.tt.sapp.global.rsData;

import com.tt.sapp.standard.dto.Empty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RsData<T> {
    private final String resultCode;
    private final String msg;
    private final T body;

    public RsData(T body) {
        this("200-1", "OK", body);
    }

    public RsData() {
        this((T) new Empty());
    }
}
