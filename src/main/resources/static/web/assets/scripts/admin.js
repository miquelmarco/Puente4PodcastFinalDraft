setTimeout(() => {
    let { createApp } = Vue;
    createApp({
        data() {
            return {
                firstName: '',
                lastName: '',
                userName: '',
                mail: '',
                nacionality: '',
                password: '',
                passwordConfirm: '',
                isLoading: false
            }
        },
        created() {
            
        },
    methods: {
        registerAdmin(){
            if(this.firstName &&
                this.lastName &&
                this.userName &&
                this.mail &&
                this.nacionality &&
                this.password) {
                    if(this.password === this.passwordConfirm) {
                        axios.post(`/api/registerAdmin`, `firstName=${this.firstName}&lastName=${this.lastName}&userName=${this.userName}&mail=${this.mail}&nacionality=${this.nacionality}&password=${this.password}`,
                        { headers: { 'content-type': 'application/x-www-form-urlencoded' } }
                        ).then(res => {
                            console.log(res)
                        }).catch(err => {
                            Swal.fire({
                                position: 'center',
                                icon: 'error',
                                title: 'Incorrect, try again!!',
                                showConfirmButton: false,
                                timer: 1500
                            });
                        })
                    }
                } else {
                    return console.log("Completa todos los datos")
                }
        }
    },
    computed: {
        
    }
}).mount("#app")
},1000)