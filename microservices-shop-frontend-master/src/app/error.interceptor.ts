import { HttpInterceptorFn, HttpErrorResponse } from '@angular/common/http';
import { throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

export const errorInterceptor: HttpInterceptorFn = (req, next) => {
  return next(req).pipe(
    catchError((error: HttpErrorResponse) => {
       if (error.status === 401) {
             console.warn('Unauthorized - redirecting to login');
           } else {
             const msg = error.error?.message || `Error ${error.status}`;
             alert(msg);
           }
           return throwError(() => error);
    })
  );
};
