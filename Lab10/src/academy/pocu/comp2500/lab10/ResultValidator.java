package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.NotFoundResult;
import academy.pocu.comp2500.lab10.pocuflix.OkResult;
import academy.pocu.comp2500.lab10.pocuflix.ResultBase;
import academy.pocu.comp2500.lab10.pocuflix.ResultCode;

public class ResultValidator {
    private ResultBase resultBase;
    public ResultValidator(ResultBase resultBase) {
        this.resultBase = resultBase;
    }
    public boolean isValid(ResultCode resultCode) {
        if (resultBase instanceof OkResult) {
            return resultBase.getCode() == ResultCode.OK && resultCode == ResultCode.OK;
        }

        if (resultBase instanceof NotFoundResult) {
            return resultBase.getCode() == ResultCode.NOT_FOUND && resultCode == ResultCode.NOT_FOUND;
        }

        if (resultBase instanceof ServiceUnavailableResult) {
            return resultBase.getCode() == ResultCode.SERVICE_UNAVAILABLE && resultCode == ResultCode.SERVICE_UNAVAILABLE;
        }

        if (resultBase instanceof UnauthorizedResult) {
            return resultBase.getCode() == ResultCode.UNAUTHORIZED && resultCode == ResultCode.UNAUTHORIZED;
        }

        if (resultBase instanceof CachedResult) {
            return resultBase.getCode() == ResultCode.NOT_MODIFIED && resultCode == ResultCode.NOT_MODIFIED;
        }

        return false;
    }

}
