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
                if (this.epSeason &&
                    this.epEpisode &&
                    this.epName &&
                    this.epLinkYt &&
                    this.epLinkIVoox &&
                    this.epImg &&
                    this.epDuration &&
                    this.epDescription) {
                    axios.post(`/api/episodes/newEpisode`, `epSeason=${this.epSeason}&epEpisode=${this.epEpisode}
                &epName=${this.epName}&epLinkYt=${this.epLinkYt}&epLinkIVoox=${this.epLinkIVoox}
                &epImg=${this.epImg}&epDuration=${this.epDuration}&epDescription=${this.epDescription}&epFeatured=${this.epFeatured}`)
                        // const requestData = {
                        //     epSeason: this.epSeason,
                        //     epEpisode: this.epEpisode,
                        //     epName: this.epName,
                        //     epLinkYt: this.epLinkYt,
                        //     epLinkIVoox: this.epLinkIVoox,
                        //     epImg: this.epImg,
                        //     epDuration: this.epDuration,
                        //     epDescription: this.epDescription,
                        //     epFeatured: this.epFeatured
                        // }
                        // axios.post(`/api/episodes/newEpisode`, requestData)
                        .then(res => {
                            this.backMsg = res.data
                            Swal.fire({
                                position: 'center',
                                icon: 'success',
                                title: `${this.backMsg}`,
                                showConfirmButton: false,
                                timer: 1500
                            })
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
            },
            eraseFields() {
                this.firstName = ''
                this.lastName = ''
                this.userName = ''
                this.mail = ''
                this.nacionality = ''
                this.password = ''
                this.passwordConfirm = '',
                this.epSeason = null,
                this.epEpisode = null,
                this.epName = '',
                this.epLinkYt = '',
                this.epLinkIVoox = '',
                this.epImg = '',
                this.epDuration = '',
                this.epDescription = '',
                this.epFeatured = false
            }
        },
        computed: {
        }
    }).mount("#app")
}, 1000)