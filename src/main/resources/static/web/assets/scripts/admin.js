setTimeout(() => {
    let { createApp } = Vue;
    createApp({
        data() {
            return {
                //data
                episodes: [],
                archives: [],

                //main
                selectedAdminPanel: '',

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

                //new archive

                archNumber: null,
                archName: '',
                archImg: '',
                archLinkYt: '',
                archLinkIVoox: '',
                archDuration: '',
                archDescription: '',

                //mod featured Ep Ar
                selectTypeMod: '',
                modEpFeatured: null,
                modArFeatured: null,

                //others
                isLoading: false,
                backMsg: ''
            }
        },
        created() {
            this.getEpisodes()
            this.getArchives()
        },
        methods: {
            getEpisodes() {
                axios.get(`/api/episodes`)
                    .then(res => {
                        this.episodes = res.data.sort((a, b) => b.id - a.id)
                    }).catch(err => console.log(err))
            },
            getArchives() {
                axios.get(`/api/archives/getArchives`)
                .then(res => {
                    this.archives = res.data.sort((a, b) => b.id - a.id)
                }).catch(err => console.log(err))
            },
            select(){
                console.log(this.selectedAdminPanel)
            },
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
                                location.reload()
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
                        .then(res => {
                            this.backMsg = res.data
                            Swal.fire({
                                position: 'center',
                                icon: 'success',
                                title: `${this.backMsg}`,
                                showConfirmButton: false,
                                timer: 1500
                            })
                            setTimeout(() => {
                                location.reload()
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
            },
            newArchive() {
                if (
                    this.archNumber &&
                    this.archName &&
                    this.archImg &&
                    this.archLinkYt &&
                    this.archLinkIVoox &&
                    this.archDuration &&
                    this.archDescription
                ) {
                    axios.post(`/api/archives/newArchive`, `archNumber=${this.archNumber}&archName=${this.archName}&archImg=${this.archImg}
                    &archLinkYt=${this.archLinkYt}&archLinkIVoox=${this.epLinkIVoox}&archDuration=${this.archDuration}&archDescription==${this.archDescription}`)
                        .then(res => {
                            this.backMsg = res.data
                            Swal.fire({
                                position: 'center',
                                icon: 'success',
                                title: `${this.backMsg}`,
                                showConfirmButton: false,
                                timer: 1500
                            })
                            setTimeout(() => {
                                location.reload()
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
            },
            modEFeatured() {
                if (this.modEpFeatured) {
                    axios.patch(`/api/modEpFeatured`, `id=${this.modEpFeatured}`)
                        .then(res => {
                            this.backMsg = res.data
                            Swal.fire({
                                position: 'center',
                                icon: 'success',
                                title: `${this.backMsg}`,
                                showConfirmButton: false,
                                timer: 1500
                            })
                            this.deleteFeatured = null
                            setTimeout(() => {
                                location.reload()
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
                            this.deleteFeatured = null
                            setTimeout(() => {
                                location.reload()
                            }, 1600)
                        })
                } else {
                    Swal.fire({
                        position: 'center',
                        icon: 'warning',
                        title: `Ingrese número de episodio`,
                        showConfirmButton: false,
                        timer: 1500
                    })
                }
            },
            modAFeatured() {
                if (this.modArFeatured) {
                    axios.patch(`/api/modArFeatured`, `id=${this.modArFeatured}`)
                        .then(res => {
                            this.backMsg = res.data
                            Swal.fire({
                                position: 'center',
                                icon: 'success',
                                title: `${this.backMsg}`,
                                showConfirmButton: false,
                                timer: 1500
                            })
                            this.deleteFeatured = null
                            setTimeout(() => {
                                location.reload()
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
                            this.deleteFeatured = null
                            setTimeout(() => {
                                location.reload()
                            }, 1600)
                        })
                } else {
                    Swal.fire({
                        position: 'center',
                        icon: 'warning',
                        title: `Ingrese número de episodio`,
                        showConfirmButton: false,
                        timer: 1500
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