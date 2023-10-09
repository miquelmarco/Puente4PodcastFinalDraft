setTimeout(() => {
    let { createApp } = Vue;
    createApp({
        data() {
            return {
                //new admin
                firstName: '',
                lastName: '',
                userName: '',
                mail: '',
                nacionality: '',
                password: '',
                passwordConfirm: '',

                //new episode
                epSeason: null,
                epEpisode: null,
                epName: '',
                epLinkYt: '',
                epLinkIVoox: '',
                epImg: '',
                epDuration: '',
                epDescription: '',
                epFeatured: false,

                //others
                isLoading: false,
                backMsg: ''
            }
        },
        created() {
        },
        methods: {
            registerAdmin() {
                if (this.firstName &&
                    this.lastName &&
                    this.userName &&
                    this.mail &&
                    this.nacionality &&
                    this.password) {
                    if (this.password === this.passwordConfirm) {
                        axios.post(`/api/registerAdmin`, `firstName=${this.firstName}&lastName=${this.lastName}&userName=${this.userName}
                        &mail=${this.mail}&nacionality=${this.nacionality}&password=${this.password}`,
                            { headers: { 'content-type': 'application/x-www-form-urlencoded' } }
                        ).then(res => {
                            this.backMsg = res.data
                            Swal.fire({
                                position: 'center',
                                icon: 'success',
                                title: `${this.backMsg}`,
                                showConfirmButton: false,
                                timer: 1500
                            })
                            setTimeout(() => {
                                this.eraseFields()
                            }, 1600)
                        }).catch(err => {
                            this.backMsg = err.response.data
                            Swal.fire({
                                position: 'center',
                                icon: 'error',
                                title: `${this.backMsg}`,
                                showConfirmButton: false,
                                timer: 1500
                            })
                        })
                    }
                } else {
                    return console.log("Completa todos los datos")
                }
            },
            newEpisode() {
                let dataDTO = {
                    epSeason: this.epSeason,
                    epEpisode: this.epEpisode,
                    epName: this.epName,
                    epLinkYt: this.epLinkYt,
                    epLinkIVoox: this.epLinkIVoox,
                    epImg: this.epImg,
                    epDuration: this.epDuration,
                    epDescription: this.epDescription,
                    epFeatured: this.epFeatured,
                }
                axios.post('/api/episodes/newEpisode', `epSeason=${this.epSeason}&epEpisode=${this.epEpisode}
                &epName=${this.epName}&epLinkYt=${this.epLinkYt}&epLinkIVoox=${this.epLinkIVoox}
                &epImg=${this.epImg}&epDuration=${this.epDuration}&epDescription=${this.epDescription}&epFeatured=${this.epFeatured}`)
                    .then(res => {
                        console.log('creado')
                    }).catch(err => {
                        console.log('no creado')
                    })
            },
            eraseFields() {
                this.firstName = ''
                this.lastName = ''
                this.userName = ''
                this.mail = ''
                this.nacionality = ''
                this.password = ''
                this.passwordConfirm = ''
            }
        },
        computed: {
        }
    }).mount("#app")
}, 1000)