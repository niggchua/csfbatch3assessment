import { Component, OnInit, inject } from '@angular/core';
import { Form, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { FormService } from '../services/form.service';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

  newsForm!: FormGroup

  public fb = inject(FormBuilder)

  fb = inject(FormBuilder)
  formSvc = inject(FormService)

  regForm!: FormGroup
  regStatus = "NA"


  ngOnInit(): void {
    this.newsForm = this.createNewsForm()
  }


  save() {
    const newsData: Form = this.newsForm.value as Form
    // { name: 'fred', email: 'fred@gmail.com' }
    console.info('>>> newsData: ', newsData)
    // this.registrationSvc.registerAsPromise(regData)
    //   .then(result => {
    //     //alert(JSON.stringify(result))
    //     this.regStatus = "success"
    //     this.regForm.reset()
    //   })
    //   .catch(error => {
    //     //alert('ERROR! ' + JSON.stringify(error))
    //     this.regStatus = "failed: " + JSON.stringify(error)
    //   })
    this.savedForm = this.formSvc.registerAsObservable(regData)
      .subscribe({
        next: result => {
          this.regStatus = result
          this.regForm.reset()
        },
        error: error => { this.regStatus = "failed: " + JSON.stringify(error) },
        complete: () => { console.info('completed ')}
      })
  }

  private createNewsForm(): FormGroup {
    return this.fb.group({
      title: this.fb.control<string>('', [ Validators.required, Validators.minLength(5) ]),
      photo: this.fb.control<
      description: this.fb.control<string>('', [ Validators.required, Validators.minLength(5) ]),
      tags: this.fb.control<string>(''),
    })
  }
}



